Feature: Delivery Approach

    Scenario: Delivery Approach One
        Given the following street specification "1 2 3 4"
        And using Delivery Approach One for delivering newspapers
        Then the delivery order will be "1 3 4 2"
        And delivery person will cross the street 1 time

    Scenario: Delivery Approach Two
        Given the following street specification "1 2 3 4"
        And using Delivery Approach Two for delivering newspapers
        Then the delivery order will be "1 2 3 4"
        And delivery person will cross the street 3 time

    Scenario: Delivery Approach One with houses on one side of street
        Given the following street specification "1 3 5"
        And using Delivery Approach One for delivering newspapers
        Then the delivery order will be "1 3 5"
        And delivery person will cross the street 0 time

    Scenario: Delivery Approach Two with houses on one side of street
        Given the following street specification "1 3 5"
        And using Delivery Approach Two for delivering newspapers
        Then the delivery order will be "1 3 5"
        And delivery person will cross the street 0 time
