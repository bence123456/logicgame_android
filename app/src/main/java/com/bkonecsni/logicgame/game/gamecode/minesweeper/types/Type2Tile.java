package com.bkonecsni.logicgame.game.gamecode.minesweeper.types;

import com.bkonecsni.logicgame.game.domain.common.Item;
import com.bkonecsni.logicgame.game.domain.common.Point;
import com.bkonecsni.logicgame.game.domain.map.CommonTile;
import com.bkonecsni.logicgame.game.domain.types.TypeStatement;
import com.bkonecsni.logicgame.game.domain.types.equation.Condition;
import com.bkonecsni.logicgame.game.domain.types.equation.Update;
import java.util.Arrays;
import java.util.List;

public class Type2Tile extends CommonTile {

    public Type2Tile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
    }

    @Override
    public void init() {
        this.typeStatementList = Arrays.asList(new TypeStatement(Arrays.asList(new Condition(1, null)), Arrays.asList(new Update(1, Item.createWithSymbol("S1")))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithSymbol("S1"))), Arrays.asList(new Update(1, Item.createWithSymbol("S2")))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithSymbol("S2"))), Arrays.asList(new Update(1, null))));
    }
}
