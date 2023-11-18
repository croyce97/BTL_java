package API;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Language {
    public static Map<String,String> Lang = new HashMap<String, String>();
    public static void input(){
        String s = "fr: Tiếng Pháp\n" +
                "it Tiếng Ý\n" +
                "ja Tiếng Nhật\n" +
                "ko Tiếng Hàn\n" +
                "ru Tiếng Nga\n" +
                "ar Tiếng Ả Rập\n" +
                "pt Tiếng Bồ Đào Nha\n" +
                "nl Tiếng Hà Lan\n" +
                "sv Tiếng Thụy Điển\n" +
                "no Tiếng Na Uy\n" +
                "da Tiếng Đan Mạch\n" +
                "fi Tiếng Phần Lan\n" +
                "pl Tiếng Ba Lan\n" +
                "cs Tiếng Séc\n" +
                "el Tiếng Hy Lạp\n" +
                "hu Tiếng Hungary\n" +
                "ro Tiếng Rumani\n" +
                "tr Tiếng Thổ Nhĩ Kỳ\n" +
                "en Tiếng Anh\n" +
                "vi Tiếng Việt\n";
        String[] k = s.split("\n");
        for (String w : k) {
            Lang.put(w.substring(3),w.substring(0,2));
        }
    }
    static {
        input();
    }

}
