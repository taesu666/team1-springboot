package lx.edu.springboot.common;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttribute {

    @ModelAttribute("userNickName")
    public String addUserNickName(HttpSession session) {
        return (String) session.getAttribute("userNickName");
    }
}
