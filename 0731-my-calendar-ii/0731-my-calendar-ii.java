// class MyCalendarTwo {
//     TreeMap<int[] , Integer> calendar;

//     // Constructor
//     public MyCalendarTwo() {
//         calendar = new TreeSet<>((a, b) -> Integer.compare(a.getKey()[0] - b.getKey()[0]));
//     }

//     public boolean book(int start, int end) {
//         int[] newEvent = new int[] {start, end};
//         int[] next = calendar.ceiling(newEvent);
//         if (next != null && next[0] < end) {
//             if(calendar.get(next) >= 2) return false;
//             next[0] = Math.min(start , next[0]);
//             next[1] = Math.min(end , next[0]);
//             calendar.put(next , 2);
//             return true;
//         }
//         int[] prev = calendar.floor(newEvent); 
//         if (prev != null && prev[1] > start) {
//             if(calendar.get(prev) >= 2) return false;
//             prev[0] = Math.min(start , prev[0]);
//             prev[1] = Math.min(end , prev[0]);
//             calendar.put(prev , 2);
//             return true; 
//         }
//         calendar.add(newEvent , 1);
//         return true;
//     }
// }
class Event
{
  int start;
  int end;
  public Event(int start, int end)
  {
    this.start = start;
    this.end = end;
  }  
}

class MyCalendarTwo {
    List<Event> overLapBookings;
    List<Event> bookings;

    public MyCalendarTwo() {
        overLapBookings = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        
    for(Event e : overLapBookings)
    {
      if(isOverlap(e, start, end))
      return false;  
    } 

    for(Event e : bookings)
    {
      if(isOverlap(e, start, end))
      {
        overLapBookings.add(getOverlapEvent(e, start, end));
      }    
    }  
       bookings.add(new Event(start, end));

       return true; 
    }

    public boolean isOverlap(Event e, int start, int end)
    {
      return Math.max(e.start, start)<Math.min(e.end, end); 
    }

    public Event getOverlapEvent(Event e, int start, int end)
    {
      return new Event(Math.max(e.start, start), Math.min(e.end, end));  
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
/**
 * Usage:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start, end);
 */
