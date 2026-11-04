package org.firstinspires.ftc.teamcode.OpMode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.MecanumDrive;


@Autonomous(name="ParkAuto")
public class RunOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d beginPose = new Pose2d(new Vector2d(60, 60), Math.toRadians(180));
                waitForStart();  // Strau waitForStart()? you have two of these?

        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        waitForStart();

        Action path = drive.actionBuilder(beginPose)
                .lineToX(39)
        .build();  // Best practice is the build your paths BEFORE waitForStart();  
                   // building the paths takes some time so its best to do it while the 
                   // robot is sitting on the starting line.  THen after you start just run
                   // the actions. - Mr. Carpenter

        Actions.runBlocking(new SequentialAction(path));

    }
}
