package org.example;

import org.example.editor.Editor;
import org.example.listeners.EmailNotificationListener;
import org.example.listeners.LogOpenListener;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        LogOpenListener openListener = new LogOpenListener("/path/to/log/file.txt");
        editor.events.subscribe("open", openListener);
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        editor.events.unsubscribe("open", openListener);
//
//        try {
//            editor.openFile("test2.txt");
//            editor.saveFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}