//
//  MobvenBugReporter.h
//  MobvenBugKit
//
//  Created by Ahmet Kazım Günay on 19/10/15.
//  Copyright © 2015 Ahmet Kazım Günay. All rights reserved.
//

#import "MobvenBugReportEventModel.h"

@interface MobvenBugReporter : MobvenBugReportEventModel

+ (void)initializeAppSecret:(NSString * _Nonnull)secret
                      appId:(NSString * _Nonnull)appId
                  projectId:(NSString * _Nonnull)projectId
                invokeTypes:(NSArray<NSNumber *> * _Nonnull)invokeTypes;

@end
