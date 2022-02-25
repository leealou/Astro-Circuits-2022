
package frc.robot;


import frc.robot.Constants.XboxConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;




public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

// The robot's subsystems
    public final Drivetrain m_drivetrain = new Drivetrain();
    public final Arm m_arm = new Arm();
    public final Scooper m_scooper = new Scooper();
    public final Climber m_climber = new Climber();

// Joysticks
private final XboxController xboxController1 = new XboxController(0);

private final int A_BUTTON = 1;


// Arm Commands
    //public static ArmUp armup = new ArmUp


  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  private RobotContainer() {
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_drivetrain);
    SmartDashboard.putData(m_arm);
    SmartDashboard.putData(m_scooper);
    SmartDashboard.putData(m_climber);



    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    //SmartDashboard.putData("ArcadeDrive", new ArcadeDrive());
    SmartDashboard.putData("Scooper_command", new Scooper_command());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();


    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());


    SmartDashboard.putData("Auto Mode", m_chooser);

    m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain,
      () -> xboxController1.getRawAxis(XboxConstants.RIGHT_STICK_Y),
      () -> -xboxController1.getRawAxis(XboxConstants.RIGHT_STICK_X))
    );
    m_arm.setDefaultCommand(new ArmMovement(m_arm, 0));

    
    
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   Button bindings go below
   */
  private void configureButtonBindings() {


    //XboxController()

    //xboxController1.getRawButton(A_BUTTON);
    

     new JoystickButton(xboxController1, XboxConstants.RIGHT_BUMPER).whenHeld(new ArmMovement(m_arm, 0.5)); // needs to be fixed
     new JoystickButton(xboxController1, XboxConstants.LEFT_BUMPER).whenHeld(new ArmMovement(m_arm, -0.5));
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public XboxController getXboxController1() {
      return xboxController1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    //return m_chooser.getSelected();

return new Autonomous(.5, 10, m_drivetrain) ;   
  }
  

}

