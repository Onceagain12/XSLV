/* Generated By:JJTree: Do not edit this line. XPathElementTest.java */

package dongfang.xsltools.xpath2;

import java.util.Collections;
import java.util.Set;

import org.dom4j.QName;

import dongfang.xsltools.exceptions.XSLToolsSchemaException;
import dongfang.xsltools.xmlclass.CharGenerator;
import dongfang.xsltools.xmlclass.schemaside.AttributeUse;
import dongfang.xsltools.xmlclass.schemaside.ElementUse;
import dongfang.xsltools.xmlclass.schemaside.SingleTypeXMLClass;
import dongfang.xsltools.xmlclass.xslside.AttributeNT;
import dongfang.xsltools.xmlclass.xslside.CommentNT;
import dongfang.xsltools.xmlclass.xslside.NodeType;
import dongfang.xsltools.xmlclass.xslside.PINT;
import dongfang.xsltools.xmlclass.xslside.RootNT;
import dongfang.xsltools.xmlclass.xslside.TextNT;
import dongfang.xsltools.xmlclass.xslside.UndeclaredNodeType;

public class XPathAttributeTest extends XPathQNamedTypedNodeTest {
  public XPathAttributeTest(int id) {
    super(id);
  }

  public XPathAttributeTest(XPathParser p, int id) {
    super(p, id);
  }

  @Override
String getKindName() {
    return "attribute";
  }

  /**
   * We can only regard the typed element test as an untyped one, and just
   * ignore the type and nillable properties.
   */
  @Override
public Set<UndeclaredNodeType> etest(Set<UndeclaredNodeType> delta) {
    QName qname = this.qname;
    if (qname == null)
      qname = NodeType.ANY_NAME;

    UndeclaredNodeType tester = new AttributeNT(/* NodeType.ANY_NAME, */qname);
    if (delta.contains(NodeType.ONE_ANY_NAME_ATTRIBUTE_NT))
      return Collections.singleton(tester);
    if (delta.contains(tester))
      return Collections.singleton(tester);
    return Collections.emptySet();
  }

  @Override
  public boolean accept(AttributeUse nt, SingleTypeXMLClass clazz)
      throws XSLToolsSchemaException {
    if (typeQName == null) {
      // case: no type
      if (getQName().getName().equals("*"))
        return true;
      return getQName().equals(nt.getQName());
    }
    if (getQName().getName().equals("*")) {
      // case: typed
      // TODO: Niller semantics!
      return nt.typeMayDeriveFrom(typeQName);
    }
    return getQName().equals(nt.getQName()) && nt.typeMayDeriveFrom(typeQName);
  }

  @Override
  boolean accept(CommentNT nt) {
    return false;
  }

  @Override
  public boolean accept(ElementUse nt, SingleTypeXMLClass clazz)
      throws XSLToolsSchemaException {
    return false;
  }

  @Override
  boolean accept(PINT nt) {
    return false;
  }

  @Override
  boolean accept(RootNT nt, SingleTypeXMLClass clazz) {
    return false;
  }

  @Override
  boolean accept(TextNT nt) {
    return false;
  }

  @Override
  public String testAttributeAxisRegExp(SingleTypeXMLClass clazz)
      throws XSLToolsSchemaException {
    if (getQName().getName().equals("*"))
      return clazz.getAttributeRegExp();
    return "" + clazz.getCharForAttributeName(getQName());
  }

  @Override
  public String testCDAxisRegExp(SingleTypeXMLClass clazz)
      throws XSLToolsSchemaException {
    return "" + CharGenerator.getAbsurdChar();
  }

  @Override
  public String testSDOSAxisRegExp(SingleTypeXMLClass clazz)
      throws XSLToolsSchemaException {
    return "" + CharGenerator.getAbsurdChar();
  }
}