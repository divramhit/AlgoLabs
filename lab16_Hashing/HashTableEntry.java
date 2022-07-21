import java.util.ArrayList;

public class HashTableEntry {
    private String nickname;
    private ArrayList<String> realName;

    public HashTableEntry(String nickname, ArrayList<String> realName) {
        this.nickname = nickname;
        this.realName = realName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getRealName() {
        String realNameStr = "";

        for (String name: this.realName) {
            realNameStr += name;
        }

        return realNameStr;
    }

    public void setRealName(ArrayList<String> realName) {
        this.realName = realName;
    }
}