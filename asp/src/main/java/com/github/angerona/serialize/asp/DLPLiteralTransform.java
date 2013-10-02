package com.github.angerona.serialize.asp;

import java.io.StringReader;

import net.sf.tweety.logicprogramming.asplibrary.parser.ASPParser;
import net.sf.tweety.logicprogramming.asplibrary.parser.InstantiateVisitor;
import net.sf.tweety.logicprogramming.asplibrary.syntax.DLPLiteral;

import org.simpleframework.xml.transform.Transform;

public class DLPLiteralTransform implements Transform<DLPLiteral> {

	@Override
	public DLPLiteral read(String value) throws Exception {
		ASPParser parser = new ASPParser(new StringReader(value));
		return new InstantiateVisitor().visit(parser.Atom(), null);
	}

	@Override
	public String write(DLPLiteral value) throws Exception {
		return value.toString();
	}

}
