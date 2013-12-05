package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import models.Paste;

import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.list;
import views.html.view;

import java.util.List;

import static play.libs.Json.setObjectMapper;
import static play.libs.Json.toJson;


public class PasteController extends Controller {

    static  {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());
        setObjectMapper(objectMapper);
    }

    public static Result newPaste() {
        return ok(views.html.add.render("", Form.form(Paste.class)));
    }

    public static Result addPaste() {
        Form<Paste> form = Form.form(Paste.class).bindFromRequest();
        Paste paste = form.get();
        paste.save();
        return redirect(routes.PasteController.view(paste.guid));
    }

    public static Result view(String guid) {
        Paste paste = (Paste)new Model.Finder(Long.class, Paste.class).where().eq("guid", guid).findUnique();
        if (paste == null) {
            return notFound("Not Found");
        }
        return ok(view.render(paste));
    }

    public static Result raw(String guid) {
        Paste paste = (Paste)new Model.Finder(Long.class, Paste.class).where().eq("guid", guid).findUnique();
        if (paste == null) {
            return notFound("Not Found");
        }
        return ok(paste.content);
    }

    public static Result json(String guid) {
        Paste paste = (Paste)new Model.Finder(Long.class, Paste.class).where().eq("guid", guid).findUnique();
        if (paste == null) {
            return notFound("Not Found");
        }

        return ok(toJson(paste));
    }

    public static Result list() {
        List<Paste> pastes = new Model.Finder(Long.class, Paste.class)
                    .setMaxRows(10)
                    .orderBy().desc("dateCreated")
                    .findList();
        return ok(list.render(pastes));
    }

    public static Result jsonList() {
        List<Paste> pastes = new Model.Finder(Long.class, Paste.class)
                .setMaxRows(10)
                .orderBy().desc("dateCreated")
                .findList();
        return ok(toJson(pastes));
    }

}
