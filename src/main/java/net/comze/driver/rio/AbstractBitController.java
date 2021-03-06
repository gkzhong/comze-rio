/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.comze.driver.rio;

import java.io.IOException;

/**
 * @author <a href="mailto:gkzhong@gmail.com">GK.ZHONG</a>
 * @since 0.1.0 Jan 14, 2013 4:56:20 PM
 * @version AbstractBitController.java 0.1.0 Jan 14, 2013 4:56:20 PM
 */
public abstract class AbstractBitController implements BitController {

	@Override
	public ReadableController asReadableController() throws IOException {
		direction(Direction.IN);
		return this;
	}

	@Override
	public WritableController asWritableController() throws IOException {
		direction(Direction.OUT);
		return this;
	}

	@Override
	public boolean read() throws IOException {
		return value();
	}

	@Override
	public void write(boolean value) throws IOException {
		value(value);
	}

	protected void assertAccessible() throws IOException {
		if (!isOpen()) {
			throw new AccessException();
		}
	}

}
