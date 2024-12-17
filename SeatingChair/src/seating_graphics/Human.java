package seating_graphics;

public class Human {
    private int xPosition;
    private int yPosition;
    private boolean isSitting;
    private int standingYPosition;
    private int sittingYPosition;
    private int chairOffsetX; // Offset to position the human beside the chair when standing

    public Human() {
        this.standingYPosition = 150;  // Y position when standing (above the chair)
        this.sittingYPosition = 250;   // Y position when sitting (aligned with chair seat)
        this.xPosition = 375;          // X position when sitting, centered on the chair
        this.yPosition = standingYPosition; // Initially standing
        this.isSitting = false;
        this.chairOffsetX = 50; // Offset for standing position (beside the chair)
    }

    public void sit(Chair chair) {
        if (!isSitting) {
            isSitting = true;
            moveToSittingPosition(chair);
        }
    }

    public void stand() {
        if (isSitting) {
            isSitting = false;
            moveToStandingPosition();
        }
    }

    private void moveToSittingPosition(Chair chair) {
        // When sitting, position the human at the center of the chair
        this.xPosition = 375;  // Centered on the chair for sitting (for office chair)
        this.yPosition = chair.getHeight() - 20;  // Position aligned with the chair seat
    }

    private void moveToStandingPosition() {
        // When standing, move human beside the chair
        this.xPosition = 375 + chairOffsetX;  // Beside the chair
        this.yPosition = standingYPosition;  // Above the chair
    }

    public boolean isSitting() {
        return isSitting;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void raiseChair(Chair chair, int amount) {
        if (chair != null) {
            chair.setHeight(chair.getHeight() + amount);
            if (isSitting) {
                yPosition -= amount;  // Raise the human with the chair
            }
        }
    }

    public void lowerChair(Chair chair, int amount) {
        if (chair != null) {
            chair.setHeight(chair.getHeight() - amount);
            if (isSitting) {
                yPosition += amount;  // Lower the human with the chair
            }
        }
    }
}

