class Letter {
    char ch;
    int count;

    Letter(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public void insert(PriorityQueue<Letter> pq, Letter letter) {
        letter.count--;
        if (letter.count > 0)
            pq.add(letter);
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Letter> pq = new PriorityQueue<>((a1, b1) -> b1.count - a1.count);
        if (a > 0)
            pq.add(new Letter('a', a));
        if (b > 0)
            pq.add(new Letter('b', b));
        if (c > 0)
            pq.add(new Letter('c', c));
        while (!pq.isEmpty()) {
            Letter letter = pq.poll();
            if (sb.length() < 2) {
                sb.append(letter.ch);
                insert(pq, letter);
            } else {
                char firstOccurence = sb.charAt(sb.length() - 2);
                char secondOccurence = sb.charAt(sb.length() - 1);
                if (firstOccurence == secondOccurence && letter.ch == secondOccurence) {
                    if (pq.isEmpty())
                        return sb.toString();
                    else {
                        Letter nextLetter = pq.poll();
                        sb.append(nextLetter.ch);
                        insert(pq, nextLetter);
                        pq.add(letter);
                    }
                } else {
                    sb.append(letter.ch);
                    insert(pq, letter);
                }
            }
        }
        return sb.toString();
    }
}