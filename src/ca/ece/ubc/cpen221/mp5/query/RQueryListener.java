// Generated from src/ca/ece/ubc/cpen221/mp5/query/RQuery.g4 by ANTLR 4.4

package ca.ece.ubc.cpen221.mp5.query;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RQueryParser}.
 */
public interface RQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RQueryParser#in}.
	 * @param ctx the parse tree
	 */
	void enterIn(@NotNull RQueryParser.InContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#in}.
	 * @param ctx the parse tree
	 */
	void exitIn(@NotNull RQueryParser.InContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#price}.
	 * @param ctx the parse tree
	 */
	void enterPrice(@NotNull RQueryParser.PriceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#price}.
	 * @param ctx the parse tree
	 */
	void exitPrice(@NotNull RQueryParser.PriceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull RQueryParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull RQueryParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#orexpr}.
	 * @param ctx the parse tree
	 */
	void enterOrexpr(@NotNull RQueryParser.OrexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#orexpr}.
	 * @param ctx the parse tree
	 */
	void exitOrexpr(@NotNull RQueryParser.OrexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(@NotNull RQueryParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(@NotNull RQueryParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#rating}.
	 * @param ctx the parse tree
	 */
	void enterRating(@NotNull RQueryParser.RatingContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#rating}.
	 * @param ctx the parse tree
	 */
	void exitRating(@NotNull RQueryParser.RatingContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull RQueryParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull RQueryParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull RQueryParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull RQueryParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#category}.
	 * @param ctx the parse tree
	 */
	void enterCategory(@NotNull RQueryParser.CategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#category}.
	 * @param ctx the parse tree
	 */
	void exitCategory(@NotNull RQueryParser.CategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RQueryParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(@NotNull RQueryParser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RQueryParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(@NotNull RQueryParser.AndexprContext ctx);
}