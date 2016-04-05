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
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

/**
 * A simple Stack implementation based on a linked list.
 *
 * @param <E> the formal type of the Stack
 */
@Invariant("size() >= 0")
public class Stack<E> {

    private LinkedList<E> internalList;

    /**
     * Initialize the stack to be empty.
     */
    @Ensures("size() == 0")
    public Stack() {
        internalList = new LinkedList<>();
    }

    /**
     * The number of elements in the Stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return internalList.size();
    }

    /**
     * Is the stack empty?
     *
     * @return true if the stack is empty
     */
    @Ensures("result == (size() == 0)")
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    /**
     * Look at the element on the top of the stack without removing it.
     *
     * @return element onto the top of the stack
     */
    @Requires("!isEmpty()")
    public E peek() {
        return internalList.getFirst();
    }

    /**
     * Push `e` onto the top of the stack.
     *
     * @param e element to push
     */
    @Ensures({
        "e == peek()", // pushed element on top
        "size() == old(size()) + 1" // size increased
    })
    public void push(E e) {
        internalList.addFirst(e);
    }

    /**
     * Pop the element onto the top of the Stack and return it.
     *
     * @return element onto the top of the stack
     */
    @Requires("!isEmpty()")
    @Ensures({
        "result == old(peek())", // return element onto the top
        "size() == old(size()) - 1" // size decreased
    })
    public E pop() {
        E e = peek();
        remove();
        return e;
    }

    /**
     * Remove the element onto the top of the Stack.
     */
    @Requires("!isEmpty()")
    @Ensures("size() == old(size()) - 1")
    public void remove() {
        internalList.removeFirst();
    }

}
