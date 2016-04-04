/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package stack;

import java.util.LinkedList;

import com.google.java.contract.Ensures;

public class Stack<E> {

    private LinkedList<E> internalList;

    public Stack() {
        internalList = new LinkedList<>();
    }

    public int size() {
        return internalList.size();
    }

    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    /**
     * Look at the element on the top of the stack without removing it.
     *
     * @return element onto the top of the stack
     */
    public E peek() {
        return internalList.getFirst();
    }

    /**
     * Push `e` onto the top of the stack.
     *
     * @param e element to push
     */
    @Ensures("e == pop()")
    public void push(E e) {
        internalList.addFirst(e);
    }

    public E pop() {
        E e = peek();
        remove();
        return e;
    }

    /**
     * Remove the element onto the top of the Stack.
     */
    public void remove() {
        internalList.removeFirst();
    }

}
