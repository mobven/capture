//
//  MobvenBugReportEventModel.h
//  TestDemoFramework
//
//  Created by Ahmet Kazim Günay on 27/10/15.
//  Copyright © 2015 Ahmet Kazım Günay. All rights reserved.
//

#import <UIKit/UIKit.h>

typedef NS_ENUM(NSUInteger, InvocationType) {
    Shake           = 0,
    ScreenShot      = 1,
    RightEdgePan    = 2,
    LeftEdgePan     = 3,
    Pinch           = 4,
    FloatingButton  = 5
};

typedef NS_ENUM(NSUInteger, ReportType) {
    ReportTypeNone            = 0,
    ReportTypeSendReport      = 1,
    ReportTypeMomentumize     = 2
};

@interface MobvenBugReportEventModel : NSObject


@end
