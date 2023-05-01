package model;

import java.util.Date;

public class UserRecord {

    private String username;
    private String ip;
    private Date time;
    private String status;

    public UserRecord( ) {
        super();
    }
    public UserRecord( String username, String ip, Date time,  String status) {

        this.username = username;
        this.ip = ip;
        this.time = time;
        this.status=status;
    }

    public String  getStatus() {
        return status;
    }

    public void setStatus(String  status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
