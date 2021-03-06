# Vehicle Violation Data Service #

:writing_hand:	

:fountain_pen:	Duddupudi Venkata Naga Harish :mailbox_closed:		Mail2dvnharish@gmail.com	

## System Scope and Context ##
### Business Context ###
To create an application that can alert police at the traffic signal about the vehicles that are at that signal have violations and penalties associated with them, which owners have not paid for a long time

## Technical Context ##
1. Application to get the feed from the camera.
2. Application to recognize the registration plate.
3. Check the registration with the database of violation vehicles.
4. Application to get the information of the police personal at that signal.
5. Application to send the alerts to the Police {SMS, VOICE}
   1.  Technical Context 1 and 2 are added to the imaginary services which gives the feed to a rest api

## Solution Straegy ##
### Building block view ###
![Alt text](/images/services-block-component.png?raw=true "vehicle  :red_car:	Violation Base POC Component Diagram")

### Scenerio Solution ###
1. The feed is sent through a service :gear: which can be either a queue :chains: , application :gear:	, rest api :bow_and_arrow:	(feed sender is not in scope we can use queues)
2. The vehicle  :red_car:	feed reciever {data-reciever} recieves the message  :envelope:	
3. Check if the vehicle  :red_car:	 is present in the government database of violation {traffic-governance} :traffic_light: :vertical_traffic_light:	
4. the filtered vehicle  :red_car:	from feed reciever will be sent through the :inbox_tray: communication server
5. the :inbox_tray: communication server will get the information from {traffic-governance} to find the beat police at that traffic signal (will get the data of phone numbers etc)
6. Once the :inbox_tray: communication server gets the requied information of location and vehicles, messages and VOIP's are sent (Not In Scope, as we just printed)




### Whitebox Overall System ###
1.	The data from the surveillance cameras are captured the registration number and sent as an object to a rest api 
2.	The Data from the capturing system is transfered to the vehicle feed reciever
3,4.  The data is captured by a consumer and the violation vehicle  :red_car:	data can be filtered out with the help of service/data from government.
5.	Then the filtered packet can be sent to the :inbox_tray: communication server where we can get the information of the police personnel who are near to the particular junction.
6,7.	With the information from the :inbox_tray: communication server and the packet from the filtered from consumer we will be having the data of violated vehicle  :red_car:	and the location of the vehicle  :red_car:	which is sent to the alert service
8.	The alert service will send the data to alerting channel. Either it can be a message of a VOIP or a message to the Walky-talky 

