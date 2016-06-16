package com.makarevich.dao.match.model;

import com.makarevich.dao.action.model.Action;
import com.makarevich.dao.actionresult.model.ActionResult;
import com.makarevich.dao.player.model.Player;
import com.makarevich.dao.subaction.model.SubAction;

import javax.persistence.*;

@Entity
@Table(name="RALLYITEM")
public class RallyItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action")
    private Action action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_action")
    private SubAction subAction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_result")
    private ActionResult actionResult;

    public Long getId() {
        return idRItems;
    }

    public void setId(Long idRItems) {
        this.idRItems = idRItems;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public SubAction getSubAction() {
        return subAction;
    }

    public void setSubAction(SubAction subAction) {
        this.subAction = subAction;
    }

    public ActionResult getActionResult() {
        return actionResult;
    }

    public void setActionResult(ActionResult actionResult) {
        this.actionResult = actionResult;
    }
}
