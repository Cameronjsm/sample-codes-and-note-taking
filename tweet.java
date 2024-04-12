/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twitter;
import java.sql.Timestamp;
/**
 *
 * @author Cameron Mosley
 */
public class tweet {
   private  int id;
   private String text;
   private Timestamp timestamp;
   private int user_id;

    public tweet(int id, String text, Timestamp timestamp, int user_id) {
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getUser_id() {
        return user_id;
    }

}
