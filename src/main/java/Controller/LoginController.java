package Controller;


import ejb.DataServicesBean;
import entities.UserEntity;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RequestScoped
@Named
public class LoginController {

    @EJB
    private DataServicesBean dataServicesBean;
    private UserEntity currentUser;


    public LoginController() {
    }

    @PostConstruct
    public void initialize() {
        this.currentUser = new UserEntity();

    }

    public UserEntity getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserEntity currentUser) {
        this.currentUser = currentUser;
    }

    public String login() {
        this.currentUser = dataServicesBean.getUserByNameAndPassword(currentUser.getName(), currentUser.getPassword());
        FacesContext context = FacesContext.getCurrentInstance();
        if (currentUser == null) {
            //currentUser = new UserEntity();
            context.addMessage(null, new FacesMessage
                    (FacesMessage.SEVERITY_ERROR, "User not found!", " Login Error!"));

            return null;
        } else {
            context.getExternalContext()
                    .getSessionMap()
                    .put("user", currentUser);

            Cookie userCookie = new Cookie("user", currentUser.getName());
            userCookie.setMaxAge(30 * 60);
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.addCookie(userCookie);
            return "index?faces-redirect=true";
        }

    }

    public String logout() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies
            ) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }

        }
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public UserEntity getSession() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();
        return (UserEntity) request.getSession().getAttribute("user");
    }

}
