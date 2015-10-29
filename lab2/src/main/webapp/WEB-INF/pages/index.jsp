<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Fingerprint</title>

    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="resources/css/freelancer.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="resources/css/sweetalert.css">

        <!-- Custom Fonts -->
        <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="//fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="resources/css/bootstrap-editable.css" rel="stylesheet"/>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="javascript:void()">Fingerprint</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="#" data-toggle="modal" data-target="#affiliatesModal">Affiliates</a>
            </li>
            <li>
              <a href="#" data-toggle="modal" data-target="#apiModal">API</a>
            </li>
          </ul>
        </div>
      <!-- /.navbar-collapse -->
      </div>
    <!-- /.container-fluid -->
    </nav>

    <header>
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="intro-text">
              <span class="name">Fingerprint</span>
              <hr class="star-light">
              <span class="skills">Algorithm for matching</span>
            </div>
          </div>
        </div>
      </div>
    </header>


    <div class="container text-center">
    <h2 class="sub-header">Casinos</h2>
    <a href="bgo" class="btn btn-primary">bgo</a>
    <a href="casino" class="btn btn-primary">casino</a>
    <a href="super-casino" class="btn btn-primary">super-casino</a>
    <br>
    <br>

    </div>

    <div class="blue-background">
      <div class="blue-background-above">
        <div class="native_table text-center">
          <h2 class="sub-header">Native fingerprints</h2>
          <div class="table-responsive">
            <table class="table table-bordered">
              <thead>
                <tr class="danger">
                  <th>id</th>
                  <th>Device type</th>
                  <th>os version</th>
                  <th>time zone</th>
                  <th>time stamp</th>
                  <th>ip</th>
                  <th>location</th>
                  <th>screen resolution</th>
                  <th>User agent</th>
                  <th>local storage</th>
                  <th>ram</th>
                  <th>carrier</th>
                </tr>
              </thead>
              <tbody id="native_fingerprint_table">

              </tbody>
            </table>
            </div>
            <button type="button" class="btn btn-default" aria-label="Left Align" onclick="loadMoreNativeFingerprints()">
                  <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
            </button>
            <br><br>

      </div>
      <div class="blue-background-below">
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-12">
              Copyright &copy; Playtech 2015
            </div>
          </div>
        </div>
      </div>
    </div></div>

    <div class="portfolio-modal modal fade" id="apiModal" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
          <div class="lr">
            <div class="rl">
            </div>
          </div>
        </div>
          <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
              <div class="modal-body">
                <h2>API</h2>
                <hr class="star-primary">
                <div class="table-responsive">
                <table class="table table-bordered">
                  <thead>
                    <tr class="danger">
                      <th>#</th>
                      <th>Parameter</th>
                      <th>Browser (FP1)</th>
                      <th>Native (FP2)</th>
                      <th>Example</th>
                      <th>Comment</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr class="success">
                      <td>1</td>
                      <td>source</td>
                      <td>Source</td>
                      <td>Source</td>
                      <td>1</td>
                      <td>Possible values: 0 for Browser, 1 for Nave Client</td>
                    </tr>
                    <tr class="warning">
                      <td>2</td>
                      <td>deviceType</td>
                      <td>Device Type</td>
                      <td>Device Type</td>
                      <td>Iphone 6</td>
                      <td></td>
                    </tr>
                    <tr class="info">
                      <td>3</td>
                      <td>osVersion</td>
                      <td>OS version</td>
                      <td>OS version</td>
                      <td>iOS 7.1.5</td>
                      <td></td>
                    </tr>
                    <tr class="success">
                      <td>4</td>
                      <td>timeZone</td>
                      <td>Time Zone</td>
                      <td>Time Zone</td>
                      <td></td>
                      <td></td>
                    </tr>
                    <tr class="warning">
                      <td>5</td>
                      <td>timeStamp</td>
                      <td>Time of download</td>
                      <td>Time of first run</td>
                      <td>2015-07-13 10:21:43</td>
                      <td></td>
                    </tr>
                    <tr class="info">
                      <td>6</td>
                      <td>ip</td>
                      <td>IP</td>
                      <td>IP</td>
                      <td>172.29.45.129</td>
                      <td></td></tr>
                    <tr class="success">
                      <td>7</td>
                      <td>location</td>
                      <td>Location (permission)</td>
                      <td>Location (permission)</td>
                      <td>40.11 31.11</td>
                      <td>Latitude and longitude</td>
                    </tr>
                    <tr class="warning">
                      <td>8</td>
                      <td>screenSize</td>
                      <td>Screen Resolution</td>
                      <td>Screen Resolution</td>
                      <td>2048x1536</td>
                      <td></td>
                    </tr>
                    <tr class="info">
                      <td>9</td>
                      <td>userAgent</td>
                      <td>User agent</td>
                      <td>User agent</td>
                      <td>Mozilla/5.0 (iPad; CPU OS 7_1_2 like Mac OS X) AppleWebkit/537.51.2 (HTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53</td>
                      <td></td>
                    </tr>
                    <tr class="success">
                      <td>10</td>
                      <td>localStorage</td>
                      <td>Local storage</td>
                      <td>Local storage</td>
                      <td>100</td>
                      <td>Local storage size</td>
                    </tr>
                    <tr class="warning">
                      <td>11</td>
                      <td>ram</td>
                      <td>RAM</td>
                      <td>RAM</td>
                      <td>100</td>
                      <td>Ram size</td>
                    </tr>
                    <tr class="info">
                      <td>12</td>
                      <td>url</td>
                      <td>Url</td>
                      <td>Url</td>
                      <td>http://example.com/</td>
                      <td>Need for browser fingerprint</td>
                    </tr>
                    <tr class="success">
                      <td>12</td>
                      <td>carrier</td>
                      <td>carrier</td>
                      <td>carrier</td>
                      <td>Mts</td>
                      <td>Provider</td>
                    </tr>
                  </tbody>
                </table></div>
                <h4>Request example</h4>
                <p>HTTP POST URL: https://api.fingerprint.com/api/v1.0/push</p>
                <p>Request body: {"source":"0","params":{"deviceType":"Galaxy S5","osVersion":"Android 5.0","timeZone":"","timeStamp": "2015-07-13 10:20:00","ip":"37.73.222.86", "location": "32;32", "screenSize":"2048x1536", "userAgent":"", "localStorage":"4", "ram": "4", "url": "http://example.com/", "carrier": "mts"}}</p>
                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
              </div>
            </div>
        </div>
      </div>
    </div>

    <div class="portfolio-modal modal fade" id="affiliatesModal" tabindex="-1" role="dialog" aria-hidden="true">
          <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
              <div class="lr">
                <div class="rl">
                </div>
              </div>
            </div>
              <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                  <div class="modal-body">
                    <h2>Affiliates</h2>
                    <hr class="star-primary">
                    <div class="table-responsive">
                    <table class="table table-bordered">
                      <thead>
                        <tr class="danger">
                          <th>id</th>
                          <th>Urls</th>
                          <th>Downloads (FP1)</th>
                          <th>Probability</th>
                        </tr>
                      </thead>
                      <tbody id="affiliates_table">

                      </tbody>
                    </table></div>
                    <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                  </div>
                </div>
            </div>
          </div>
        </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <script src="resources/js/fp.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/sweetalert.min.js"></script>
    <!-- Plugin JavaScript -->
    <script src="resources/js/classie.js"></script>
    <script src="resources/js/cbpAnimatedHeader.js"></script>
    <!-- Contact Form JavaScript -->
    <script src="resources/js/jqBootstrapValidation.js"></script>
    <script src="resources/js/contact_me.js"></script>
    <script src="resources/js/deviceatlas-1.3.min.js"></script>
    <script src="resources/js/bootstrap-editable.min.js"></script>
</body></html>