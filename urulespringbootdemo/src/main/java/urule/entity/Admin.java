package urule.entity;
import com.bstek.urule.console.User;

/**
 * Created by HT on 2019/1/30.
 */
public class Admin implements User{
    private String username;
    private String companyId;
    private boolean isAdmin;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
