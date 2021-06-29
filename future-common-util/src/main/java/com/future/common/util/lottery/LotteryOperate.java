package com.future.common.util.lottery;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author future
 * @date 2020-05-26 10:57
 */
public class LotteryOperate {

    /**
     * 功能描述: 抽奖算法
     *
     * @author future
     * @date 2020/5/26 11:15 上午
     */
    public static Award getLottery(List<Award> lotteries) {
        lotteries.sort(Comparator.comparingInt(Award::getRate));
        int length = 0;
        for (Award award : lotteries) {
            length += award.getRate();
        }
        int i = 0;
        int size = lotteries.size();
        for (; i < size; i++) {
            double random = Math.random() * length;
            Integer rate = lotteries.get(i).getRate();
            if (random < rate) {
                break;
            } else {
                length -= rate;
            }
        }
        return lotteries.get(i);
    }


    public static void main(String[] args) {
        List<Award> awardList = new ArrayList<>();
        Award a = new Award("A", "1", 20);
        Award b = new Award("B", "2", 30);
        Award c = new Award("C", "3", 30);
        Award d = new Award("D", "4", 20);
        awardList.add(a);
        awardList.add(b);
        awardList.add(c);
        awardList.add(d);

        int j = 0;
        int k = 0;
        int m = 0;
        int n = 0;
        for (int i = 0; i < 10000; i++) {
            Award award = getLottery(awardList);
            switch (award.getAwardId()) {
                case "1":
                    j++;
                    break;
                case "2":
                    k++;
                    break;
                case "3":
                    m++;
                    break;
                case "4":
                    n++;
                    break;
                default:
            }
        }
        System.out.println(j + "-" + k + "-" + m + "-" + n);
    }

}
