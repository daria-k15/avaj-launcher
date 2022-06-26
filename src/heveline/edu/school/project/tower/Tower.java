package heveline.edu.school.project.tower;

import heveline.edu.school.project.Logger;
import heveline.edu.school.project.aviation.AircraftFactory;
import heveline.edu.school.project.aviation.Flyable;
import heveline.edu.school.project.exception.AvajLauncherException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings({"FieldMayBeFinal", "MismatchedQueryAndUpdateOfCollection"})
abstract public class Tower {
    int duration;
    String[] params;
    private LinkedList<Flyable> observes = new LinkedList<>();

    public void initTower(String filePath){
        try {
            Scanner scanner = new Scanner(new File(filePath));
            if (scanner.hasNext()){
                try {
                    duration = Integer.parseInt(scanner.nextLine());
                } catch(NumberFormatException e){
                    System.out.println("Invalid steps count");
                }
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                params = line.split(" ");
                register(AircraftFactory.newAircraft(
                        params[0],
                        params[1],
                        Integer.parseInt(params[2]),
                        Integer.parseInt(params[3]),
                        Integer.parseInt(params[4])));
            }
            scanner.close();
        } catch(FileNotFoundException e){
            throw new AvajLauncherException("File not found!");
        } catch(NumberFormatException e){
            throw new AvajLauncherException("Invalid coordinates");
        } catch (ArrayIndexOutOfBoundsException e){
            throw new AvajLauncherException("Invalid data");
        } catch (Exception e){
            throw new AvajLauncherException("No such aircraft type: " + e.getMessage());
        }
    }

    protected void setTower(Tower tower){
        for (Flyable flyable : observes)
            flyable.registerTower(tower);
    }

    private void register(Flyable flyable){
        observes.add(flyable);
        Logger.logRegistration(flyable);
    }

    protected void changeCondition(){
        for (Flyable flyable : observes){
            flyable.updateConditions();
        }
    }
    private void unregister(Flyable flyable){
        observes.remove(flyable);
        System.out.println("Tower unregistered: " + flyable.toString() + " from weather tower");
    }

}
