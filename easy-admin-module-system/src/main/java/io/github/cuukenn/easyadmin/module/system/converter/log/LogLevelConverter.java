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
package io.github.cuukenn.easyadmin.module.system.converter.log;

import io.github.cuukenn.easyadmin.module.system.controller.admin.log.vo.LogLevelResVo;
import io.github.cuukenn.easyadmin.module.system.service.log.dto.LogLevelDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @author changgg
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LogLevelConverter {
	LogLevelConverter INSTANCE = Mappers.getMapper(LogLevelConverter.class);

	/**
	 * dto2vo
	 *
	 * @param dto dto
	 * @return vo
	 */
	LogLevelResVo toLogLevelResVo(LogLevelDto dto);
}
