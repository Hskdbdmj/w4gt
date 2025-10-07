package com.example.maktabatnihad;

import java.util.HashMap;

public class PDFLinks {
    private static final HashMap<String, String> books = new HashMap<>();
    private static final HashMap<String, Integer> booksPages = new HashMap<>();
    private static final HashMap<String, String> notes = new HashMap<>();
    private static final HashMap<String, Integer> notesPages = new HashMap<>();
    private static final HashMap<String, String> assetNames = new HashMap<>();

    static {
        // BOOKS (official) - asset file names must match files you put in /assets
        books.put("اللغة العربيه الجزء الاول", "arabic_part1.pdf"); booksPages.put("اللغة العربيه الجزء الاول",136); assetNames.put("book:اللغة العربيه الجزء الاول","arabic_part1.pdf");
        books.put("اللغة العربيه الجزء الثاني", "arabic_part2.pdf"); booksPages.put("اللغة العربيه الجزء الثاني",136); assetNames.put("book:اللغة العربيه الجزء الثاني","arabic_part2.pdf");
        books.put("الرياضيات", "maths.pdf"); booksPages.put("الرياضيات",196); assetNames.put("book:الرياضيات","maths.pdf");
        books.put("الاجتماعيات", "social.pdf"); booksPages.put("الاجتماعيات",140); assetNames.put("book:الاجتماعيات","social.pdf");
        books.put("علم الاحياء", "bio.pdf"); booksPages.put("علم الاحياء",92); assetNames.put("book:علم الاحياء","bio.pdf");
        books.put("الكيمياء", "chem.pdf"); booksPages.put("الكيمياء",96); assetNames.put("book:الكيمياء","chem.pdf");
        books.put("الفيزياء", "phys.pdf"); booksPages.put("الفيزياء",88); assetNames.put("book:الفيزياء","phys.pdf");
        books.put("اللغة الانكليزية(للكراس)", "eng_activity.pdf"); booksPages.put("اللغة الانكليزية(للكراس)",127); assetNames.put("book:اللغة الانكليزية(للكراس)","eng_activity.pdf");
        books.put("اللغة الانكليزيه(الملون)", "eng_color.pdf"); booksPages.put("اللغة الانكليزيه(الملون)",120); assetNames.put("book:اللغة الانكليزيه(الملون)","eng_color.pdf");
        books.put("الحاسوب", "computer_book.pdf"); booksPages.put("الحاسوب",144); assetNames.put("book:الحاسوب","computer_book.pdf");
        books.put("التربيه الاسلاميه", "islamic_book.pdf"); booksPages.put("التربيه الاسلاميه",120); assetNames.put("book:التربيه الاسلاميه","islamic_book.pdf");

        // NOTES (malaazem)
        notes.put("ملزمه اسلاميه ثانى متوسط", "note_islam.pdf"); notesPages.put("ملزمه اسلاميه ثانى متوسط",68); assetNames.put("note:ملزمه اسلاميه ثانى متوسط","note_islam.pdf");
        notes.put("ملزمة العربي الجزء الاول", "note_arabic_p1.pdf"); notesPages.put("ملزمة العربي الجزء الاول",78); assetNames.put("note:ملزمة العربي الجزء الاول","note_arabic_p1.pdf");
        notes.put("ملزمة العربي الجزء الثاني", "note_arabic_p2.pdf"); notesPages.put("ملزمة العربي الجزء الثاني",83); assetNames.put("note:ملزمة العربي الجزء الثاني","note_arabic_p2.pdf");
        notes.put("ملزمة اللغة الانكليزية", "note_eng.pdf"); notesPages.put("ملزمة اللغة الانكليزية",128); assetNames.put("note:ملزمة اللغة الانكليزية","note_eng.pdf");
        notes.put("ملزمة الرياضيات", "note_math.pdf"); notesPages.put("ملزمة الرياضيات",159); assetNames.put("note:ملزمة الرياضيات","note_math.pdf");
        notes.put("ملزمة الكيمياء", "note_chem.pdf"); notesPages.put("ملزمة الكيمياء",59); assetNames.put("note:ملزمة الكيمياء","note_chem.pdf");
        notes.put("ملزمة الفيزياء", "note_phys.pdf"); notesPages.put("ملزمة الفيزياء",104); assetNames.put("note:ملزمة الفيزياء","note_phys.pdf");
        notes.put("ملزمة الاجتماعيات", "note_social.pdf"); notesPages.put("ملزمة الاجتماعيات",68); assetNames.put("note:ملزمة الاجتماعيات","note_social.pdf");
    }

    public static String[] getBooksList(){
        return books.keySet().toArray(new String[0]);
    }

    public static String[] getNotesList(){
        return notes.keySet().toArray(new String[0]);
    }

    public static String getAssetName(String type, String name){
        return assetNames.get(type+":"+name);
    }

    public static String getUrl(String type, String name){
        return null;
    }

    public static int getPages(String type, String name){
        if(type.equals("books")){
            return booksPages.get(name);
        } else {
            return notesPages.get(name);
        }
    }
}
