<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page contentType="text/html; charset=utf-8"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<head>
<meta charset="utf-8">
<link href="<c:url value="/resources/css/views/userPage.css" />"
	rel="stylesheet">

<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAqWugaywaw1C1FQ0bjlV1z--wQ_ZQJOc4&callback=initialize"></script>
<script>
                function googleMaps() {
                    var googleMapPointAchi = {
                        center: new google.maps.LatLng(52.8, 17.4),
                        zoom: 8,
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    };
                    var googleMapZoneAchi = {
                        center: new google.maps.LatLng(56.5, 11.5),
                        zoom: 6,
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    };
                    var mapPointAchi = new google.maps.Map(document.getElementById("googleMapPointAchi"), googleMapPointAchi);
                    var mapZoneAchi = new google.maps.Map(document.getElementById("googleMapZoneAchi"), googleMapZoneAchi);

///////////////// USER LANDMARK ACHI ACHIEVED/////////////////                   

                    var sharedInfoWindow = new google.maps.InfoWindow();

                    var landmarkAchiLat_achieved = [
                <c:forEach var="landmarkAchi" items="${userAchievedLandmarkAchiList}">
                    <c:out value="${landmarkAchi.latitude}"/>,
                </c:forEach>
                    ];
                    var landmarkAchiLng_achieved = [
                <c:forEach var="landmarkAchi" items="${userAchievedLandmarkAchiList}">
                    <c:out value="${landmarkAchi.longitude}"/>,
                </c:forEach>
                    ];
                    var landmarkAchiDescription_achieved = [
                <c:forEach var="landmarkAchi" items="${userAchievedLandmarkAchiList}">
                        "<c:out value="${landmarkAchi.description}"/>",
                </c:forEach>
                    ];
                    var landmarkAchiName_achieved = [
                <c:forEach var="landmarkAchi" items="${userAchievedLandmarkAchiList}">
                        "<c:out value="${landmarkAchi.name}"/>",
                </c:forEach>
                    ];
                    var landmarkAchiIcon_achieved = {
                        url: "/resources/images/markers/landmarkMarker_green.gif",
                        scaledSize: new google.maps.Size(20, 40),
                        origin: new google.maps.Point(0, 0),
                        anchor: new google.maps.Point(10, 40)
                    };
                    var landmarkAchiMarker_achieved, i;
                    var landmarkAchiInfoWindow_achieved = new google.maps.InfoWindow();

                    for (i = 0; i < landmarkAchiLat_achieved.length; i++) {

                        landmarkAchiMarker_achieved = new google.maps.Marker({
                            position: new google.maps.LatLng(landmarkAchiLat_achieved[i], landmarkAchiLng_achieved[i]),
                            icon: landmarkAchiIcon_achieved,
                            map: mapPointAchi
                        });

                        google.maps.event.addListener(landmarkAchiMarker_achieved, 'click', (function (landmarkAchiMarker_achieved, i) {
                            return function () {
                                sharedInfoWindow.setContent("<div style='text-align:center;'><h3>" + landmarkAchiName_achieved[i] + "</h3><p>" + landmarkAchiDescription_achieved[i] + "</p></div>");
                                sharedInfoWindow.open(mapPointAchi, landmarkAchiMarker_achieved);
                            }
                        })(landmarkAchiMarker_achieved, i));
                    }

///////////////// USER LANDMARK ACHI UNDONE/////////////////                   

                    var landmarkAchiLat_undone = [
                <c:forEach var="landmarkAchi" items="${userUndoneLandmarkAchiList}">
                    <c:out value="${landmarkAchi.latitude}"/>,
                </c:forEach>
                    ];
                    var landmarkAchiLng_undone = [
                <c:forEach var="landmarkAchi" items="${userUndoneLandmarkAchiList}">
                    <c:out value="${landmarkAchi.longitude}"/>,
                </c:forEach>
                    ];
                    var landmarkAchiDescription_undone = [
                <c:forEach var="landmarkAchi" items="${userUndoneLandmarkAchiList}">
                        "<c:out value="${landmarkAchi.description}"/>",
                </c:forEach>
                    ];
                    var landmarkAchiName_undone = [
                <c:forEach var="landmarkAchi" items="${userUndoneLandmarkAchiList}">
                        "<c:out value="${landmarkAchi.name}"/>",
                </c:forEach>
                    ];
                    var landmarkAchiIcon_undone = {
                        url: "/resources/images/markers/landmarkMarker_white.gif",
                        scaledSize: new google.maps.Size(20, 40),
                        origin: new google.maps.Point(0, 0),
                        anchor: new google.maps.Point(10, 40)
                    };
                    var landmarkAchiMarker_undone;
                    var landmarkAchiInfoWindow_undone = new google.maps.InfoWindow();
                    for (var i = 0; i < landmarkAchiLat_undone.length; i++) {
                        landmarkAchiMarker_undone = new google.maps.Marker({
                            position: new google.maps.LatLng(landmarkAchiLat_undone[i], landmarkAchiLng_undone[i]),
                            icon: landmarkAchiIcon_undone,
                            map: mapPointAchi
                        });

                        google.maps.event.addListener(landmarkAchiMarker_undone, 'click', (function (landmarkAchiMarker_undone, i) {
                            return function () {
                                sharedInfoWindow.setContent("<div style='text-align:center;'><h3>" + landmarkAchiName_undone[i] + "</h3><p>" + landmarkAchiDescription_undone[i] + "</p></div>");
                                sharedInfoWindow.open(mapPointAchi, landmarkAchiMarker_undone);
                            }
                        })(landmarkAchiMarker_undone, i));
                    }

///////////////// USER TOWN ACHI ACHIEVED/////////////////                   

                    var townAchiLat_achieved = [
                <c:forEach var="townAchi" items="${userAchievedTownAchiList}">
                    <c:out value="${townAchi.latitude}"/>,
                </c:forEach>
                    ];
                    var townAchiLng_achieved = [
                <c:forEach var="townAchi" items="${userAchievedTownAchiList}">
                    <c:out value="${townAchi.longitude}"/>,
                </c:forEach>
                    ];
                    var townAchiDescription_achieved = [
                <c:forEach var="townAchi" items="${userAchievedTownAchiList}">
                        "<c:out value="${townAchi.description}"/>",
                </c:forEach>
                    ];
                    var townAchiName_achieved = [
                <c:forEach var="townAchi" items="${userAchievedTownAchiList}">
                        "<c:out value="${townAchi.name}"/>",
                </c:forEach>
                    ];
                    var townAchiIcon_achieved = {
                        url: "/resources/images/markers/townMarker_green.gif",
                        scaledSize: new google.maps.Size(20, 40),
                        origin: new google.maps.Point(0, 0),
                        anchor: new google.maps.Point(10, 40)
                    };
                    var townAchiMarker_achieved;
                    var townAchiInfoWindow_achieved = new google.maps.InfoWindow();
                    for (var i = 0; i < townAchiLat_achieved.length; i++) {
                        townAchiMarker_achieved = new google.maps.Marker({
                            position: new google.maps.LatLng(townAchiLat_achieved[i], townAchiLng_achieved[i]),
                            icon: townAchiIcon_achieved,
                            map: mapPointAchi
                        });

                        google.maps.event.addListener(townAchiMarker_achieved, 'click', (function (townAchiMarker_achieved, i) {
                            return function () {
                                sharedInfoWindow.setContent("<div style='text-align:center;'><h3>" + townAchiName_achieved[i] + "</h3><p>" + townAchiDescription_achieved[i] + "</p></div>");
                                sharedInfoWindow.open(mapZoneAchi, townAchiMarker_achieved);
                            }
                        })(townAchiMarker_achieved, i));
                    }


///////////////// USER TOWN ACHI UNDONE/////////////////                   

                    var townAchiLat_undone = [
                <c:forEach var="townAchi" items="${userUndoneTownAchiList}">
                    <c:out value="${townAchi.latitude}"/>,
                </c:forEach>
                    ];
                    var townAchiLng_undone = [
                <c:forEach var="townAchi" items="${userUndoneTownAchiList}">
                    <c:out value="${townAchi.longitude}"/>,
                </c:forEach>
                    ];
                    var townAchiDescription_undone = [
                <c:forEach var="townAchi" items="${userUndoneTownAchiList}">
                        "<c:out value="${townAchi.description}"/>",
                </c:forEach>
                    ];
                    var townAchiName_undone = [
                <c:forEach var="townAchi" items="${userUndoneTownAchiList}">
                        "<c:out value="${townAchi.name}"/>",
                </c:forEach>
                    ];
                    var townAchiIcon_undone = {
                        url: "/resources/images/markers/townMarker_white.gif",
                        scaledSize: new google.maps.Size(20, 40),
                        origin: new google.maps.Point(0, 0),
                        anchor: new google.maps.Point(10, 40)
                    };
                    var townAchiMarker_undone;
                    var townAchiInfoWindow_undone = new google.maps.InfoWindow();
                    for (var i = 0; i < townAchiLat_undone.length; i++) {
                        townAchiMarker_undone = new google.maps.Marker({
                            position: new google.maps.LatLng(townAchiLat_undone[i], townAchiLng_undone[i]),
                            icon: townAchiIcon_undone,
                            map: mapPointAchi
                        });

                        google.maps.event.addListener(townAchiMarker_undone, 'click', (function (townAchiMarker_undone, i) {
                            return function () {
                                sharedInfoWindow.setContent("<div style='text-align:center;'><h3>" + townAchiName_undone[i] + "</h3><p>" + townAchiDescription_undone[i] + "</p></div>");
                                sharedInfoWindow.open(mapZoneAchi, townAchiMarker_undone);
                            }
                        })(townAchiMarker_undone, i));
                    }


///////////////// USER ZONE ACHI ACHIEVED/////////////////   

                    var zoneAchi_North_achieved = [
                <c:forEach var="zoneAchi" items="${userAchievedZoneAchiList}">
                    <c:out value="${zoneAchi.north_border}"/>,
                </c:forEach>
                    ];
                    var zoneAchi_South_achieved = [
                <c:forEach var="zoneAchi" items="${userAchievedZoneAchiList}">
                    <c:out value="${zoneAchi.south_border}"/>,
                </c:forEach>
                    ];
                    var zoneAchi_East_achieved = [
                <c:forEach var="zoneAchi" items="${userAchievedZoneAchiList}">
                    <c:out value="${zoneAchi.east_border}"/>,
                </c:forEach>
                    ];
                    var zoneAchi_West_achieved = [
                <c:forEach var="zoneAchi" items="${userAchievedZoneAchiList}">
                    <c:out value="${zoneAchi.west_border}"/>,
                </c:forEach>
                    ];

                    var zoneAchiRectangles_achieved;

                    for (var i = 0; i < zoneAchi_North_achieved.length; i++) {
                        zoneAchiRectangles_achieved = new google.maps.Rectangle({
                            strokeColor: '#004d00',
                            strokeOpacity: 0.9,
                            strokeWeight: 2,
                            fillColor: '#004d00',
                            fillOpacity: 0.40,
                            map: mapZoneAchi,
                            bounds: {
                                north: zoneAchi_North_achieved[i],
                                south: zoneAchi_South_achieved[i],
                                east: zoneAchi_East_achieved[i],
                                west: zoneAchi_West_achieved[i]
                            }
                        });
                    }

///////////////// USER ZONE ACHI UNDONE/////////////////   

                    var zoneAchi_North_undone = [
                <c:forEach var="zoneAchi" items="${userUndoneZoneAchiList}">
                    <c:out value="${zoneAchi.north_border}"/>,
                </c:forEach>
                    ];
                    var zoneAchi_South_undone = [
                <c:forEach var="zoneAchi" items="${userUndoneZoneAchiList}">
                    <c:out value="${zoneAchi.south_border}"/>,
                </c:forEach>
                    ];
                    var zoneAchi_East_undone = [
                <c:forEach var="zoneAchi" items="${userUndoneZoneAchiList}">
                    <c:out value="${zoneAchi.east_border}"/>,
                </c:forEach>
                    ];
                    var zoneAchi_West_undone = [
                <c:forEach var="zoneAchi" items="${userUndoneZoneAchiList}">
                    <c:out value="${zoneAchi.west_border}"/>,
                </c:forEach>
                    ];

                    var zoneAchiRectangles_undone;

                    for (var i = 0; i < zoneAchi_North_undone.length; i++) {
                        zoneAchiRectangles_undone = new google.maps.Rectangle({
                            strokeColor: '#ff0000',
                            strokeOpacity: 0.9,
                            strokeWeight: 2,
                            fillColor: '#ffffff',
                            fillOpacity: 0.40,
                            map: mapZoneAchi,
                            bounds: {
                                north: zoneAchi_North_undone[i],
                                south: zoneAchi_South_undone[i],
                                east: zoneAchi_East_undone[i],
                                west: zoneAchi_West_undone[i]
                            }
                        });
                    }
                }
                google.maps.event.addDomListener(window, 'load', googleMaps);
            </script>

<script>
                function mapChangePoint(select) {
                    var element0 = document.getElementById("noMap");
                    element0.style.display = 'none';
                    switch (select) {
                        case '1':
                            var map1 = document.getElementById("googleMapPointAchi");
                            map1.style.display = 'block';
                            google.maps.event.trigger(map1, 'resize');
                            var map2 = document.getElementById("googleMapZoneAchi");
                            map2.style.display = 'none';
                            var button1 = document.getElementById("buttonPoint");
                            button1.style.backgroundColor = '#00994d';
                            var button2 = document.getElementById("buttonZone");
                            button2.style.backgroundColor = '#f44336';
                            break;
                        case '2':
                            var map1 = document.getElementById("googleMapPointAchi");
                            map1.style.display = 'none';
                            var map2 = document.getElementById("googleMapZoneAchi");
                            map2.style.display = 'block';
                            google.maps.event.trigger(map2, 'resize');
                            var button1 = document.getElementById("buttonPoint");
                            button1.style.backgroundColor = '#f44336';
                            var button2 = document.getElementById("buttonZone");
                            button2.style.backgroundColor = '#00994d';
                            break;
                        default:
                            break;
                    }
                }
            </script>

		</head>

		<body>

			<table class="userPageTableGroup">
				<tr>
					<td class="userName" name="userName">
						<div>${userName}</div>
					</td>

					<td class="mapButton" id="buttonPoint">
						<div>
							<button type="submit" onclick="mapChangePoint('1')">POINT
								MAP</button>
						</div>
					</td>

					<td class="mapButton" id="buttonZone">
						<div>
							<button type="submit" onclick="mapChangePoint('2')">ZONE
								MAP</button>
						</div>
					</td>
				</tr>

				<tr>
					<td class="statisticsGroup" name="statistics">
						<table id="statisticsTable">
							<tr>
								<th colspan="2">
									<p>STATISTICS</p>
								</th>
							</tr>
							<tr>
								<td id="statisticsTableLeft_total">
									<p>Total Achievements</p>
								</td>
								<td id="statisticsTableRight_total">
									<p>${userTotalAllAchievements}</p>
								</td>
							</tr>
							<tr>
								<td id="statisticsTableLeft">
									<p>Point Achievements</p>
								</td>
								<td id="statisticsTableRight">
									<p>${userTotalPointAchievements}</p>
								</td>
							</tr>
							<tr>
								<td id="statisticsTableLeft">
									<p>Zone Achievemants</p>
								</td>
								<td id="statisticsTableRight">
									<p>${userTotalZoneAchievements}</p>
								</td>
							</tr>
						</table>
					</td>

					<td class="mapGroup" rowspan="3" colspan="3">
						<div class="userPageMap" id="noMap">SELECT MAP WITH YOUR
							ACHIEVEMENTS</div>
						<div class="userPageMap" id="googleMapPointAchi"></div>
						<div class="userPageMap" id="googleMapZoneAchi"></div>
					</td>
				</tr>

				<tr>
					<td class="achievementsGroup">
						<table id="latestAchiTable">
							<tr>
								<th colspan="2">
									<p>LAST 3 ACHIEVEMENTS DONE</p>
								</th>
							</tr>
							<tr>
								<td colspan="2" id="latestAchiTableHeader">
									<p>POINT ACHIEVEMENTS</p>
								</td>
							</tr>

							<c:forEach var="pointAchi" items="${userLatestPointAchiList}">
								<tr>
									<td id="latestAchiTableLeft"><c:out
											value="${pointAchi.name}" /></td>
									<td id="latestAchiTableRight"><c:out
											value="${pointAchi.description}" /></td>
								</tr>
							</c:forEach>

							<tr>
								<td colspan="2" id="latestAchiTableHeader">
									<p>ZONE ACHIEVEMENTS</p>
								</td>
							</tr>

							<c:forEach var="zoneAchi" items="${userLatestZoneAchiList}">
								<tr>
									<td id="latestAchiTableLeft"><c:out
											value="${zoneAchi.name}" /></td>
									<td id="latestAchiTableRight"><c:out
											value="${zoneAchi.description}" /></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>

				<tr>
					<td class="ratingsGroup">
						<table>
							<tr>
								<th colspan="2">
									<p>RATINGS</p>
								</th>
							</tr>
							<tr>
								<td id="ratingsTableLeft">
									<p>Point Achievements Rank</p>
								</td>
								<td id="ratingsTableRight">
									<p>${userAchiPointRank}</p>
								</td>
							</tr>
							<tr>
								<td id="ratingsTableLeft">
									<p>Zone Achievements Rank</p>
								</td>
								<td id="ratingsTableRight">
									<p>${userAchiZoneRank}</p>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>
