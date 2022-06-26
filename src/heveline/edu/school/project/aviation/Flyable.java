package heveline.edu.school.project.aviation;

import heveline.edu.school.project.tower.Tower;

public interface Flyable {
    void updateConditions();
    void registerTower(Tower tower);
    String toString();
}
