package models;


import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class BinTest {

        @Test
        public void create() {
            running(fakeApplication(), new Runnable() {
                public void run() {
                    Paste paste = new Paste();
                    paste.setContent("abc123");
                    paste.save();
                    assertThat(paste.getId()).isNotNull();
                    assertThat(paste.getGuid()).isNotNull();
                    assertThat(paste.getContent()).isEqualTo("abc123");


                }
            });
        }

    }


