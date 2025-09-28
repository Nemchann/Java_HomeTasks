class Time {
    int allSeconds;
    //    В теле класса действия описывать нельзя, только в методе
    public String toString(){
        int seconds = this.allSeconds;
        int minutes = 0;
        int hours = 0;

        while(seconds >= 60){
            seconds -= 60;
            minutes++;
        }
        while(minutes >= 60){
            minutes -= 60;
            hours++;
        }
        while(hours >= 24) {
            hours -= 24;
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


}