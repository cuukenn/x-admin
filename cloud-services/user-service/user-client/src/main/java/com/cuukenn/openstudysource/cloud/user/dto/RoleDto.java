package com.cuukenn.openstudysource.cloud.user.dto;

import com.cuukenn.openstudysource.cloud.framework.dto.Dto;

import javax.validation.constraints.NotBlank;

/**
 * @author changgg
 */
public class RoleDto extends Dto {
    private static final long serialVersionUID = -1L;
    private Long id;
    @NotBlank
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
