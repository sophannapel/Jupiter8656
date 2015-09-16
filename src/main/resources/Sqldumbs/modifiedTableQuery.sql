/*
 Date: 09/16/2015 PM
 Description: Add foreign key constraint for releaseId to userstory table.
*/

ALTER TABLE userstory
ADD FOREIGN KEY (releaseId)
REFERENCES releaseBacklog(id);
