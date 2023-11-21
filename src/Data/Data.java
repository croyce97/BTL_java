package Data;

import java.sql.SQLException;
import java.util.ArrayList;

public class Data {
    private static final RadixTree<Word> radixtree = new RadixTree<Word>();
    public static int idxMax = 0;
    static {
        importFromDatabase();
    }
    public static ArrayList<Word> prefixSearch(String prefix) {
        prefix = prefix.toLowerCase();
        return radixtree.prefixSearch(prefix, 100);
    }

    public static void importFromDatabase() {
        LoadWordFromDataBase.LoadWord();
        for (Word w : LoadWordFromDataBase.List) {
            idxMax = Math.max(idxMax, w.getIdx())+1;
            radixtree.insert(new String(w.getWord() + String.valueOf(w.getIdx())).toLowerCase(), w);
        }
    }
    public static void Add(Word w) {
        idxMax++;
        radixtree.insert(new String(w.getWord() + String.valueOf(w.getIdx())).toLowerCase(), w);
        UpdateSQL.Add(w);
    }
    public static void Delete(Word w) {
        radixtree.delete((w.getWord() + String.valueOf(w.getIdx())).toLowerCase());
        UpdateSQL.DeleteWord(w);
    }
    public static void Update(Word w) {
        UpdateSQL.UpdateWord(w);
    }

}
