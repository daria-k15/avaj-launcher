package heveline.edu.school.project.tower;

import heveline.edu.school.project.Logger;
import heveline.edu.school.project.aviation.AircraftFactory;
import heveline.edu.school.project.aviation.Flyable;
import heveline.edu.school.project.aviation.MD5;
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
            if (!scanner.hasNext()){
                throw new AvajLauncherException("File is empty!");
            }
            try {
                duration = Integer.parseInt(scanner.nextLine());
                if (duration < 0){
                    throw new AvajLauncherException("Duration can't be negative!");
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid steps count");
            }
            if (!scanner.hasNext()){
                throw new AvajLauncherException("Add weather providers!");
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                params = line.split(" ");
                if (params.length != 5){
                    throw new Exception("Wrong parameter number!");
                }
                if (filePath.endsWith("scenario.txt")){
                    register(AircraftFactory.newAircraft(
                            params[0],
                            params[1],
                            Integer.parseInt(params[2]),
                            Integer.parseInt(params[3]),
                            Integer.parseInt(params[4])));
                } else {
                    register(MD5.newMD5Aircraft(
                            params[0],
                            params[1],
                            Integer.parseInt(params[2]),
                            Integer.parseInt(params[3]),
                            Integer.parseInt(params[4])));
                }
            }
            scanner.close();
        } catch(FileNotFoundException e){
            throw new AvajLauncherException("File not found!");
        } catch(NumberFormatException e){
            throw new AvajLauncherException("Invalid coordinates");
        } catch (ArrayIndexOutOfBoundsException e){
            throw new AvajLauncherException("Invalid data");
        } catch (Exception e){
            throw new AvajLauncherException(e.getMessage());
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
}