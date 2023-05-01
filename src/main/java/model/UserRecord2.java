package model;

import java.time.LocalDateTime;
import java.util.Date;

public class UserRecord2 {
    private String username;
    private String ip;
    private LocalDateTime time;
    private String status;

    public UserRecord2( ) {
        super();
    }
    public UserRecord2( String username, String ip, LocalDateTime time,  String status) {

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
