/* Generated By:JJTree: Do not edit this line. XPathRangeExpr.java */

package dongfang.xsltools.xpath2;

public class XPathRangeExpr extends XPathBase implements XPathExpr {
  public XPathRangeExpr(int id) {
    super(id);
  }

  public XPathRangeExpr(XPathParser p, int id) {
    super(p, id);
  }

  public short getType() {
    return TYPE_ANY; // TODO: sharpen
  }

  @Override
public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(jjtGetChild(0).toString());
    if (jjtGetNumChildren() > 1) {
      res.append(" to ");
      res.append(jjtGetChild(1).toString());
    }
    return res.toString();
  }
}