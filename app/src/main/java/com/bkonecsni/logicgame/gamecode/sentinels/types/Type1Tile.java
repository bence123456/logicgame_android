package com.bkonecsni.logicgame.gamecode.sentinels.types;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import com.bkonecsni.logicgame.domain.map.CommonTile;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;
import java.util.Arrays;
import java.util.List;

public class Type1Tile extends CommonTile {

    public Type1Tile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
    }

    @Override
    public void init() {
        this.typeStatementList = Arrays.asList(new TypeStatement(Arrays.asList(new Condition(1, null)), Arrays.asList(new Update(1, Item.createWithSymbol("S1")))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithSymbol("S1"))), Arrays.asList(new Update(1, Item.createWithSymbol("S2")))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithSymbol("S2"))), Arrays.asList(new Update(1, null))));
    }
}
