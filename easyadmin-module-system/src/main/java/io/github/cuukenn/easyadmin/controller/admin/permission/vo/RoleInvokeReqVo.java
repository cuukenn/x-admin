/*
 * Copyright 2022 changgg.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.cuukenn.easyadmin.controller.admin.permission.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

/**
 * @author changgg
 */
@Schema(title = "权限：用户角色授权reqVo")
@Data
@ToString
public class RoleInvokeReqVo {
	@Schema(title = "用户id")
	private Long userId;
	@Schema(title = "待授权角色ids")
	private Set<Long> menuIds;
}
