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
package io.github.cuukenn.easyframework.jpa.dao;

import io.github.cuukenn.easyframework.core.dao.ITenant;

import javax.persistence.MappedSuperclass;

/**
 * @author changgg
 */
@MappedSuperclass
public abstract class AbstractJpaTenantEntityRepeated extends AbstractJpaEntityRepeated implements ITenant {
	private static final long serialVersionUID = -1L;
	/**
	 * 租户ID
	 */
	private Long tenantId;

	@Override
	public Long getTenantId() {
		return tenantId;
	}

	@Override
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
}
