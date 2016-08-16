package org.thiki.kanban.passwordRetrieval;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by xubt on 8/8/16.
 */
public class RegisterEmail {
    @NotNull(message = "用于找回密码的邮箱不能为空.")
    @Email(message = "邮箱格式错误.")
    @Length(max = 40, message = "邮箱超出长度限制。")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
