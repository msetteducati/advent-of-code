package com.msetteducati.y2023.d6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Race {
    private long time;
    private long recordDistance;

    public long getNumWinCombinations() {
        long left = 1, right = this.getTime() / 2, mid, curDistance;

        while (left < right) {
            mid = left + (right - left) / 2;
            curDistance = mid * (this.getTime() - mid);

            if (curDistance > this.getRecordDistance()) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return this.getTime() - (2 * left) + 1;
    }
}