/* Generated By:JJTree: Do not edit this line. XPathUnaryExpr.java */

package dongfang.xsltools.xpath2;

public class XPathUnaryExpr extends XPathBase implements XPathArithmeticExpr {
  private char sign;

  public XPathUnaryExpr(int id) {
    super(id);
  }

  public XPathUnaryExpr(XPathParser p, int id) {
    super(p, id);
  }

  void setSign(char s) {
    sign = s;
  }

  void setSign(String s) {
    sign = s.charAt(0);
  }

  void reduce() {
    if (sign != '-') {
      Node parent = jjtGetParent();
      int card;
      for (card = 0; card < parent.jjtGetNumChildren(); card++) {
        if (this == parent.jjtGetChild(card)) {
          break;
        }
      }
      // // hmmm....
      parent.jjtAddChild(jjtGetChild(0), card);
    }
  }

  public short getType() {
    return TYPE_NUM; // TODO: right?
  }

  @Override
public String toString() {
    if (sign != 0)
      return sign + jjtGetChild(0).toString();
    return jjtGetChild(0).toString();
  }
}