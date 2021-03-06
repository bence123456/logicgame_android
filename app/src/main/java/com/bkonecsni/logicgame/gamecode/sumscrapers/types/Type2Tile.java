package com.bkonecsni.logicgame.gamecode.sumscrapers.types;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import com.bkonecsni.logicgame.domain.map.CommonTile;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;
import java.util.Arrays;
import java.util.List;

public class Type2Tile extends CommonTile {

    public Type2Tile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
    }

    @Override
    public void init() {
        this.typeStatementList = Arrays.asList(new TypeStatement(Arrays.asList(new Condition(1, null)), Arrays.asList(new Update(1, Item.createWithIntValue(1)))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithIntValue(1))), Arrays.asList(new Update(1, Item.createWithIntValue(2)))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithIntValue(2))), Arrays.asList(new Update(1, Item.createWithIntValue(3)))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithIntValue(3))), Arrays.asList(new Update(1, Item.createWithIntValue(4)))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithIntValue(4))), Arrays.asList(new Update(1, null))));
    }
}
