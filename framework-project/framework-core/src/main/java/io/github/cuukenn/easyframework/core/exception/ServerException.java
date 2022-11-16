/*
 * Copyright 2022 the original author or authors.
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
package io.github.cuukenn.easyframework.core.exception;

import io.github.cuukenn.easyframework.core.pojo.IResult;

/**
 * 服务器异常
 *
 * @author changgg
 */
public class ServerException extends RuntimeException implements IResult {
	private final Integer code;

	public ServerException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.code = errorCode.getCode();
	}

	public ServerException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
