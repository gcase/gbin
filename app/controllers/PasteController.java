package controllers;

import models.Paste;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.list;
import views.html.view;

import java.util.List;

import static play.libs.Json.toJson;

public class PasteController extends Controller {

    public static Result newPaste() {
        return ok(views.html.add.render("", Form.form(Paste.class)));
    }

    public static Result addPaste() {
        Form<Paste> form = Form.form(Paste.class).bindFromRequest();
        Paste paste = form.get();
        paste.save();
        return redirect(controllers.routes.PasteController.list());
    }

    public static Result view(String guid) {
        Paste paste = (Paste)new Model.Finder(String.class, Paste.class).where().eq("guid", guid).findUnique();
        return ok(view.render(paste));
    }

    public static Result raw(String guid) {
        Paste paste = (Paste)new Model.Finder(String.class, Paste.class).where().eq("guid", guid).findUnique();
        return ok(paste.content);
    }

    public static Result list() {
        List<Paste> pastes = new Model.Finder(String.class, Paste.class).all();
        return ok(list.render(pastes));
    }

    public static Result jsonList() {
        List<Paste> pastes = new Model.Finder(String.class, Paste.class).all();
        return ok(toJson(pastes));
    }

}
