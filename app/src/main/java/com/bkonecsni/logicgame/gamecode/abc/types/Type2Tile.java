package com.bkonecsni.logicgame.gamecode.abc.types;

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
        this.typeStatementList = Arrays.asList(new TypeStatement(Arrays.asList(new Condition(1, null)), Arrays.asList(new Update(1, Item.createWithCharValue('A')))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithCharValue('A'))), Arrays.asList(new Update(1, Item.createWithCharValue('B')))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithCharValue('B'))), Arrays.asList(new Update(1, Item.createWithCharValue('C')))), new TypeStatement(Arrays.asList(new Condition(1, Item.createWithCharValue('C'))), Arrays.asList(new Update(1, null))));
    }
}
