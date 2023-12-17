// job scheduling with deadline

// uniprocessor -

// jobid deadline profit
// A 2 55
// B 1 17
// C 2 12
// D 1 27
// simpkle approch
// a55 c12
// 0 1 2 profit : 67
// Greedy approch
// 27 55
// 0 1 2 profit : 82

import java.util.*;

class jobdata {
    char id;
    int deadline;
    int profit;

    jobdata(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

};

public class jobschedulrwithdeadline {

    public static void scheduleJobs(jobdata jobs[]) {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        boolean result[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!result[j]) {
                    System.out.print(jobs[i].id + " ");
                    result[j] = true;
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        jobdata[] jobs = {
                new jobdata('a', 2, 60),
                new jobdata('b', 1, 100),
                new jobdata('c', 3, 20),
                new jobdata('d', 1, 40),

        };
        scheduleJobs(jobs);
    }
}
