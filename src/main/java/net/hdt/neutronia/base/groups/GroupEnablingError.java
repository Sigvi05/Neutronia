package net.hdt.neutronia.base.groups;

public class GroupEnablingError extends RuntimeException {

    public GroupEnablingError(Group group) {
        super(String.format("Error enabling group ", group.name));
    }

}
