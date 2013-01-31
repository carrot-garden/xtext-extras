/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.serializer;

import org.eclipse.xtext.junit4.serializer.SerializerTester;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FunctionTypeRefAwareInjectorProvider2 extends XbaseNewTypeSystemInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new FunctionTypeRefAwareTestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public static class FunctionTypeRefAwareTestStandaloneSetup extends XbaseNewTypeSystemTestStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new XbaseNewTypeSystemTestRuntimeModule() {
				@Override
				public void configure(com.google.inject.Binder binder) {
					super.configure(binder);
					binder.bind(SerializerTester.class).to(XFunctionTypeRefAwareSerializerTester.class);
				}
				
			});
		}
	}
}