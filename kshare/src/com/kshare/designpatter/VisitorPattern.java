package com.kshare.designpatter;
/*
abstract class ExpressionVisitor{
    abstract void visit(Value value);
    abstract void visit();
}

public class VisitorPattern {
    public static void main(String[] args) {

    }
}

abstract class Visitor{

    abstract void visit(this);
}
abstract class Expression{
    abstract void accept(ExpressionVisitor ev);
}

class Value extends Expression{
    public int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    void accept(ExpressionVisitor ev) {

    }
}
class AdditionalExpression extends  Expression{
    Expression left, right;
    AdditionalExpression
    @Override

    public AdditionalExpression

    public AdditionalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    void accept(ExpressionVisitor ev) {
    ev.visit(ev);
    }
}
*/